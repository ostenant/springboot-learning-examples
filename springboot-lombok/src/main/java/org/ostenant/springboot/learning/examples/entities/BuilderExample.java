package org.ostenant.springboot.learning.examples.entities;

import java.util.List;

/**
 * @Data
 * @Builder
 */
public class BuilderExample {

    private Integer id;

    private String name;

    private List<String> hobbies;

    @java.beans.ConstructorProperties({"id", "name", "hobbies"})
    BuilderExample(Integer id, String name, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.hobbies = hobbies;
    }

    public static BuilderExampleBuilder builder() {
        return new BuilderExampleBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getHobbies() {
        return this.hobbies;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof BuilderExample)) return false;
        final BuilderExample other = (BuilderExample) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$hobbies = this.getHobbies();
        final Object other$hobbies = other.getHobbies();
        if (this$hobbies == null ? other$hobbies != null : !this$hobbies.equals(other$hobbies)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $hobbies = this.getHobbies();
        result = result * PRIME + ($hobbies == null ? 43 : $hobbies.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof BuilderExample;
    }

    public String toString() {
        return "org.ostenant.springboot.learning.examples.entities.BuilderExample(id=" + this.getId() + ", name=" + this.getName() + ", hobbies=" + this.getHobbies() + ")";
    }

    public static class BuilderExampleBuilder {
        private Integer id;
        private String name;
        private List<String> hobbies;

        public BuilderExampleBuilder() {
        }

        public BuilderExample.BuilderExampleBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public BuilderExample.BuilderExampleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BuilderExample.BuilderExampleBuilder hobbies(List<String> hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public BuilderExample build() {
            return new BuilderExample(id, name, hobbies);
        }

        public String toString() {
            return "org.ostenant.springboot.learning.examples.entities.BuilderExample.BuilderExampleBuilder(id=" + this.id + ", name=" + this.name + ", hobbies=" + this.hobbies + ")";
        }
    }
}
