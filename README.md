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


## Actualización v 1.0.2

La Actualización incluye pruebas unitarias implementadas con JUnit para asegurar la calidad y el correcto funcionamiento del juego. Las pruebas cubren diferentes aspectos del juego, como la lógica de marcar y revelar casillas, la obtención de coordenadas, y la verificación del estado del juego.

### Ejecución de las Pruebas Unitarias

Para ejecutar las pruebas unitarias, sigue estos pasos:

1. **En tu IDE:**

   - Localiza la clase `BuscaminasTestSuite.java`.
   - Haz clic derecho en la clase y selecciona "Run" o "Ejecutar" (o la opción equivalente en tu IDE). Esto ejecutará todas las pruebas definidas en esa clase.
   - Tu IDE mostrará los resultados de las pruebas, indicando qué pruebas pasaron, fallaron o fueron ignoradas. Presta atención a cualquier prueba que falle, ya que esto podría indicar un problema en tu código.

3. **Desde la línea de comandos (Maven o Gradle):**

   - **Con Maven:** Navega a la raíz de tu proyecto en la terminal y ejecuta el siguiente comando:
     ```bash
     mvn test
     ```
     Maven ejecutará todas las pruebas unitarias y mostrará los resultados en la consola. Busca un resumen al final de la ejecución que indique el número de pruebas, los fallos y los errores.

   - **Con Gradle:** Navega a la raíz de tu proyecto en la terminal y ejecuta el siguiente comando:
     ```bash
     ./gradlew test
     ```
     Gradle también ejecutará las pruebas unitarias y mostrará los resultados en la consola. Similar a Maven, busca un resumen al final.

### Descripción de las Pruebas

Las pruebas unitarias en `BuscaminasTestSuite` incluyen:

- **testMarcarCasilla:** Verifica que se pueda marcar y desmarcar una casilla correctamente.
- **testObtenerCoordenadas:** Asegura que se obtengan coordenadas válidas e inválidas.
- **testRevelarCasilla:** Comprueba que se pueda revelar una casilla y que no se pueda revelar una casilla ya descubierta.
- **testInicializacionCasillas:** Verifica que todas las casillas se inicialicen correctamente.
- **testColocarMinas:** Asegura que se coloquen el número correcto de minas en el tablero.
- **testCalcularMinasAlrededor:** Verifica que se calculen correctamente las minas alrededor de una casilla.
- **testJuegoGanado:** Comprueba que el juego se considere ganado cuando todas las casillas sin mina están descubiertas.

### Consejos para las Pruebas Unitarias

- **Escribe pruebas para todos los casos:** Asegúrate de cubrir todos los escenarios posibles en tus pruebas, incluyendo casos límite y situaciones excepcionales.
- **Pruebas legibles:** Escribe nombres de pruebas descriptivos que indiquen claramente qué se está probando. Esto facilita la comprensión de los resultados de las pruebas y la depuración.
- **Automatización:** Considera integrar la ejecución de las pruebas unitarias en tu proceso de construcción (por ejemplo, usando un servidor de integración continua) para detectar errores de forma temprana.

**Por Christian Taipe**
