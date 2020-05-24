import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product extends ObjectPlusPlus  {
    private String code;
    private String name;
    private String symbol;
    private String author;
    private Boolean isActive;
    private Map<String, Parameter> parameters = new HashMap<>();

    public Product(String code, String name, String symbol, String author, Boolean isActive) {
        super();
        this.code = code;
        this.name = name;
        this.symbol = symbol;
        this.author = author;
        this.isActive = isActive;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getActive() {
        return isActive;
    }

    @Override
    public String toString() {
        String info = "Product{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                "}\n";

        for(Parameter p : parameters.values()) {
            info += "   parameter " + p.getCode() +":" + p.getValue() + "\n";
        }
        return info;
    }

    public Parameter createParameter(String code, String value) throws Exception {
        Parameter param = new Parameter(code, value);
        parameters.put(code, param);
        return param;
    }

    public void removeParameter(String code) {
        if(!parameters.containsKey(code)) return;
        parameters.remove(code);
    }

    public Map<String, Parameter> getParameters() {
        return parameters;
    }

    public Parameter getParameter(String code) {
        Parameter p = null;
        if(parameters.containsKey(code)) {
            p = parameters.get(code);
        }
        return p;
    }

    public class Parameter {
        private String code;
        private String value;

        public Parameter(String code, String value) throws Exception {
            if(isCodeExists(code)) {
                throw new Exception("Can't create parameter. Code " + code + " exists in the product.");
            }
            this.code = code;
            this.value = value;
        }

        public Boolean isCodeExists(String code) {
            return parameters.containsKey(code);
        }

        public String getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }


        public void setValue(String value) {
            this.value = value;
        }

        public String getProductName() {
            return Product.this.getName();
        }

        @Override
        public String toString() {
            return "Parameter{" +
                    "code='" + code + '\'' +
                    ", value='" + value + '\'' +
                    "}:"+"Produkt{"+ getProductName() +"}\n";
        }
    }
}
