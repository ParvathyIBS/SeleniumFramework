package healing;

public class ElementMetadata {

    private String elementName;
    private String tagName;
    private String text;
    private String id;
    private String className;

    public ElementMetadata(String elementName, String tagName, String text, String id, String className) {
        this.elementName = elementName;
        this.tagName = tagName;
        this.text = text;
        this.id = id;
        this.className = className;
    }

    public String getElementName() {
        return elementName;
    }

    public String getTagName() {
        return tagName;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }
}