package co.edu.javeriana.aes.modval.helloworld.entity;

import javax.xml.bind.annotation.*;

/**
 * Auto-generated class based on the canonical representation for HelloWorld
 * xjc -d HelloWorld/src/main/java/co/edu/javeriana/aes/modval/helloworld/entity
 * -p co.edu.javeriana.aes.modval.helloworld.entity HelloWorld.xsd
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HelloWorld", propOrder = {
        "greeting"
})
public class HelloWorld {

    @XmlElement(required = true)
    protected String greeting;

    public HelloWorld() {
    }

    public HelloWorld(String greeting) {
        this.greeting = greeting;
    }

    /**
     * Gets the value of the greeting property.
     */
    public String getGreeting() {
        return greeting;
    }
}
