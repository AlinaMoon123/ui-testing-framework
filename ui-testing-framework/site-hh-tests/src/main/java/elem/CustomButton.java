package elem;

import elements.Button;

public class CustomButton extends Button {

    protected CustomButton(String XPath) {
        super(XPath);
    }

    public static CustomButton byDataQa(String dataQaValue) {
        String xpath = buildByAttribute("data-qa", dataQaValue);
        return new CustomButton(xpath);
    }

    public static CustomButton byContainsDataQa(String dataQaValue) {
        String xpath = buildByContainsAttribute("data-qa", dataQaValue);
        return new CustomButton(xpath);
    }

}

