package org.ostenant.springboot.learning.examples.mybatis.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;
import java.util.stream.Collectors;

public class StatementRenamePlugin extends PluginAdapter {

    /**
     * Statement ID KEY
     */
    private static final String STATEMENT_ID_ATTRIBUTE = "id";
    /**
     * Statement ID VALUE(findByIds)
     */
    private static final String STATEMENT_FIND_BY_IDS = "findByIds";

    /**
     * select Element
     */
    private static final String SELECT_XML_ELEMENT = "select";

    /**
     * include Element
     */
    private static final String INCLUDE_XML_ELEMENT = "include";

    /**
     * foreach Element
     */
    private static final String FOREACH_ELEMENT = "foreach";

    /**
     * parameterType Attribute
     */
    private static final String PARAMETER_TYPE_ATTRIBUTE = "parameterType";

    /**
     * resultMap Attribute
     */
    private static final String RESULT_MAP_ATTRIBUTE = "resultMap";

    /**
     * refid Attribute
     */
    private static final String REFID_ATTRIBUTE = "refid";

    /**
     * collection Attribute
     */
    private static final String COLLECTION_ATTRIBUTE = "collection";

    /**
     * item Attribute
     */
    private static final String ITEM_ATTRIBUTE = "item";

    /**
     * open Attribute
     */
    private static final String OPEN_ATTRIBUTE = "open";

    /**
     * separator Attribute
     */
    private static final String SEPARATOR_ATTRIBUTE = "separator";

    /**
     * close Attribute
     */
    private static final String CLOSE_ATTRIBUTE = "close";

    /**
     * java.util.List
     */
    private static final String PARAMETER_TYPE_LIST = "java.util.List";

    /**
     * BaseResultMap
     */
    private static final String BASE_RESULT_MAP = "BaseResultMap";

    /**
     * Base_Column_List
     */
    private static final String Base_Column_List = "Base_Column_List";

    //

    /**
     * selectByPrimaryKey
     */
    private static final String SELECT_BY_PRIMARY_KEY_METHOD = "selectByPrimaryKey";


    private FullyQualifiedJavaType listJavaType = new FullyQualifiedJavaType("java.util.List");


    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * Mapper.xml文档DOM生成树，可以把自己的Statement挂在DOM树上。
     * 添加findByIds的SQL Statement
     *
     * @param document          SQLMapper.xml 文档树描述对象
     * @param introspectedTable 表描述对象
     * @return
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement rootElement = document.getRootElement();
        // <select></select>
        XmlElement statement = new XmlElement(SELECT_XML_ELEMENT);
        // id="findByIds"
        statement.getAttributes().add(0, new Attribute(STATEMENT_ID_ATTRIBUTE, STATEMENT_FIND_BY_IDS));
        // parameterType="java.util.List"
        statement.getAttributes().add(new Attribute(PARAMETER_TYPE_ATTRIBUTE, PARAMETER_TYPE_LIST));
        // resultMap="BaseResultMap"
        statement.getAttributes().add(new Attribute(RESULT_MAP_ATTRIBUTE, BASE_RESULT_MAP));

        TextElement select = new TextElement(SELECT_XML_ELEMENT);
        XmlElement include = new XmlElement(INCLUDE_XML_ELEMENT);
        include.getAttributes().add(new Attribute(REFID_ATTRIBUTE, Base_Column_List));

        TextElement from = new TextElement("from " + introspectedTable.getTableConfiguration().getTableName());

        XmlElement foreach = new XmlElement(FOREACH_ELEMENT);
        foreach.getAttributes().add(0, new Attribute(COLLECTION_ATTRIBUTE, "list"));
        foreach.getAttributes().add(1, new Attribute(ITEM_ATTRIBUTE, "item"));
        foreach.getAttributes().add(2, new Attribute(OPEN_ATTRIBUTE, "("));
        foreach.getAttributes().add(3, new Attribute(SEPARATOR_ATTRIBUTE, ","));
        foreach.getAttributes().add(new Attribute(CLOSE_ATTRIBUTE, ")"));

        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();

        TextElement foreachContent = new TextElement("#{item,jdbcType=" + primaryKeyColumns.get(0).getJdbcTypeName() + "}");
        foreach.addElement(0, foreachContent);

        statement.addElement(select);
        statement.addElement(include);
        statement.addElement(from);
        statement.addElement(foreach);

        rootElement.addElement(statement);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    /**
     * Mapper.java接口生成树，可以把自己的方法挂接在此接口上
     * List findByIds(List list);
     *
     * @param interfaze         Mapper接口信息描述对象
     * @param topLevelClass     此数据库表对应的实体类描述对象
     * @param introspectedTable 表描述对象
     * @return
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        FullyQualifiedJavaType entityJavaType = interfaze.getMethods()
                .stream()
                .filter(m -> m.getName().equals(SELECT_BY_PRIMARY_KEY_METHOD))
                .distinct()
                .map(Method::getReturnType)
                .collect(Collectors.toList())
                .get(0);

        FullyQualifiedJavaType primaryKeyJavaType = interfaze.getMethods()
                .stream()
                .filter(m -> m.getName().equals(SELECT_BY_PRIMARY_KEY_METHOD))
                .distinct()
                .map(Method::getParameters)
                .map(parameters -> parameters.get(0).getType())
                .collect(Collectors.toList())
                .get(0);

        interfaze.addImportedType(listJavaType);
        Method method = new Method();
        method.setName(STATEMENT_FIND_BY_IDS);

        FullyQualifiedJavaType listEntityJavaType = new FullyQualifiedJavaType(listJavaType.getShortName());
        listEntityJavaType.addTypeArgument(entityJavaType);

        FullyQualifiedJavaType listPrimaryKeyJavaType = new FullyQualifiedJavaType(listJavaType.getShortName());
        listPrimaryKeyJavaType.addTypeArgument(primaryKeyJavaType);

        method.setReturnType(listEntityJavaType);
        method.setVisibility(JavaVisibility.DEFAULT);
        method.addParameter(0, new Parameter(listPrimaryKeyJavaType, "list"));

        interfaze.addMethod(method);

        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }
}
