
# @SpringBootApplication

@SpringBootApplication = @ComponentScan + @EnableAutoConfiguration

```java
package com.tuana9a.learn.springboot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * tự động quest component không cần @ComponentScan
 * phạm vi quét, mọi class, mọi package cùng cấp đổ xuống (quét mọi nút con)
 */
@ComponentScan("com.tuana9a")
@EnableAutoConfiguration
public class AutoConfigApplication {

}

```

equals

```java
package com.tuana9a.learn.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpingBootApplication
public class Application {
    
}
```