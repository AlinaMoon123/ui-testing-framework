package elem;

import elements.TextInput;

public class CustomInput extends TextInput {

    protected CustomInput(String XPath) {
        super(XPath);
    }

    public static CustomInput byDataQa(String dataQaValue) {
        String xpath = buildByAttribute("data-qa", dataQaValue);
        return new CustomInput(xpath);
    }

    public static CustomInput byContainsDataQa(String dataQaValue) {
        String xpath = buildByContainsAttribute("data-qa", dataQaValue);
        return new CustomInput(xpath);
    }
}
