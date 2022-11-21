package bean;

import java.beans.Expression;
import java.beans.Statement;
public class GetSetBeanProperty {
 
    public static void main(String[] args) throws Exception {
 
        Object o = new Bean("a","a");
 
        Statement stmt;
        Expression expr;
 
        // Set the value of property1
        stmt = new Statement(o, "setProperty1", new Object[]{"My Prop Value"});
        stmt.execute();
 
        // Get the value of property1
        expr = new Expression(o, "getProperty1", new Object[0]);
        expr.execute();
        System.out.println("Property1 value: " + (String)expr.getValue());
 
        /////////////////////////////////////////////
 
        // Set the value of property2
        stmt = new Statement(o, "setProperty2", new Object[]{"aaa"});
        stmt.execute();
 
        // Get the value of property2
        expr = new Expression(o, "getProperty2", new Object[0]);
        expr.execute();
        System.out.println("Property2 value: " + (String)expr.getValue());
 
    }
 
    public static class Bean {
 
        // Property property1
        private String property1;
        // Property property2
        private String property2;
 
        public String getProperty1() {
            return property1;
        }
        public void setProperty1(String property1) {
            this.property1 = property1;
        }
 
        public String getProperty2() {
            return property2;
        }
        public void setProperty2(String property2) {
            this.property2 = property2;
        }

        public Bean(String property1, String property2) {
            this.property1 = property1;
            this.property2 = property2;
        }
        
        
 
    }
 
}