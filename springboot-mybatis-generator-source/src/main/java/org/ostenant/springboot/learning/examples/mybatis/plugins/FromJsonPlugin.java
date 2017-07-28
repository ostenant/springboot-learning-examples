package org.ostenant.springboot.learning.examples.mybatis.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.util.Iterator;
import java.util.List;

public class FromJsonPlugin extends PluginAdapter {
    private final static String JSON_ATTR_GETTER = "JSONAttrGetter";


    private FullyQualifiedJavaType jsonObject = new FullyQualifiedJavaType("com.alibaba.fastjson.JSONObject");
    private FullyQualifiedJavaType jsonAttrGetter = new FullyQualifiedJavaType("org.ostenant.springboot.learning.examples.mybatis.utils.JSONAttrGetter");

    public FromJsonPlugin() {
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateFromJson(introspectedTable, introspectedTable.getAllColumns(), topLevelClass);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateFromJson(introspectedTable, introspectedTable.getAllColumns(), topLevelClass);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateFromJson(introspectedTable, introspectedTable.getAllColumns(), topLevelClass);
        return true;
    }

    private void generateFromJson(IntrospectedTable introspectedTable, List<IntrospectedColumn> introspectedColumns, TopLevelClass topLevelClass) {
        String fullyQualifiedName = topLevelClass.getType().getFullyQualifiedName();
        String shortName = topLevelClass.getType().getShortName();
        FullyQualifiedJavaType entityJavaType = new FullyQualifiedJavaType(fullyQualifiedName);

        topLevelClass.addImportedType(jsonObject);
        topLevelClass.addImportedType(jsonAttrGetter);

        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(entityJavaType);
        method.setName("fromJson");
        method.setStatic(true);

        Parameter parameter = new Parameter(jsonObject, "fromJsonObj");
        method.getParameters().add(parameter);

        method.addBodyLine("if (fromJsonObj == null || fromJsonObj.isEmpty()){");
        method.addBodyLine("return null;");
        method.addBodyLine("}");

        StringBuilder sb = new StringBuilder();
        sb.append(shortName.substring(0, 1).toLowerCase()).append(shortName.substring(1));
        String instanceName = sb.toString();
        sb.setLength(0);

        sb.append(shortName).append(" ")
                .append(instanceName).append(" ")
                .append("=").append(" ")
                .append("new").append(" ")
                .append(shortName).append(";");
        method.addBodyLine(sb.toString());

        for (Iterator iter = introspectedColumns.iterator(); iter.hasNext(); method.addBodyLine(sb.toString())) {
            IntrospectedColumn introspectedColumn = (IntrospectedColumn) iter.next();
            sb.setLength(0);

            String javaProperty = introspectedColumn.getJavaProperty();
            String setterMethod = JavaBeansUtil.getSetterMethodName(javaProperty);
            sb.append(instanceName).append(".")
                    .append(setterMethod)
                    .append("(")
                    .append(JSON_ATTR_GETTER).append(".")
                    .append("getString").append("(")
                    .append("fromJsonObj")
                    .append(", ")
                    .append("")
                    .append("));");

        }

    }

    public static void main(String[] args) {
        String name = "modelSceneId";
        char[] upperCharArray = {
                'Q', 'W', 'E', 'R', 'T',
                'Y', 'U', 'I', 'O', 'P',
                'A', 'S', 'D', 'F', 'G',
                'H', 'J', 'K', 'L', 'Z',
                'X', 'C', 'V', 'B', 'N',
                'M'};

        char[] charArray = name.toCharArray();
        for (int i = 0; i < charArray.length; i++) {

        }
        
    }

}
