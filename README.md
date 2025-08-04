# Proyecto Buscaminas realese v 1.0.0

## Descripción

Este proyecto implementa el clásico juego de Buscaminas en Java. El juego permite a los usuarios revelar casillas, marcar posibles minas y tratar de despejar el tablero sin activar ninguna mina.


## Requisitos

*   Java Development Kit (JDK) 8 o superior.
*   Un IDE (IntelliJ IDEA, Eclipse, etc.) o un editor de texto con un sistema de construcción como Maven o Gradle.
*   JUnit 4 o superior (asegúrate de que la dependencia esté configurada correctamente en tu proyecto).

## Configuración

1.  **Clonar el repositorio (si aplica):**
    Si el proyecto está en un repositorio, clona el repositorio en tu máquina local.

    ```bash
    git clone https://github.com/Chrstqn/buscaminasTaipeCh.git
    ```

2.  **Configurar el entorno de desarrollo:**
    *   Asegúrate de tener el JDK instalado y configurado correctamente.
    *   Importa el proyecto en tu IDE.
    *   Si usas Maven o Gradle, el IDE debería reconocer y configurar automáticamente las dependencias. Si no, asegúrate de agregar la dependencia de JUnit a tu archivo `pom.xml` (Maven) o `build.gradle` (Gradle).

    **Ejemplo para Maven (pom.xml):**

    ```xml
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
    ```

    **Ejemplo para Gradle (build.gradle):**

    ```groovy
    testImplementation 'junit:junit:4.13.2'
    ```

## Ejecución

1.  **Ejecutar el juego:**
    *   Ejecuta la clase `ControladorJuego` (o la clase principal que inicie el juego) desde tu IDE.
    *   Sigue las instrucciones en la consola para jugar.

2.  **Ejecutar las pruebas unitarias:**
    *   En tu IDE, ve a la clase `BuscaminasTestSuite.java`.
    *   Haz clic derecho en la clase y selecciona "Run" o "Ejecutar".
    *   Alternativamente, si usas Maven o Gradle, puedes ejecutar las pruebas desde la línea de comandos:

    ```bash
    # Con Maven
    mvn test

    # Con Gradle
    ./gradlew test
    ```

**Por Christian Taipe**
