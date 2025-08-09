#   Juego por Turnos – Proyecto Java

Videojuego de combate por turnos desarrollado en **Java** aplicando Programación Orientada a Objetos, herencia, manejo de colecciones y persistencia en base de datos.

---

##   Cómo jugar

1. Al iniciar el juego, cada jugador deberá:
   - Ingresar su nombre.
   - Seleccionar una raza disponible: **Humano**, **Elfo**, **Orco** o **Bestia**.
   - Elegir un arma según las reglas de su raza.
   
2. El combate se desarrolla **por turnos**:
   - El **Jugador 1** realiza su acción (atacar y sanar).
   - El **Jugador 2** realiza su acción.
   - Se repite hasta que uno de los personajes quede con 0 de vida.

3. Reglas básicas:
   - Cada raza tiene armas y habilidades únicas.
   - Algunas armas tienen daño fijo, otras daño aleatorio.
   - Las habilidades de sanación y daño extra dependen de la raza y el arma.
   - Gana el jugador que deje sin vida al oponente.

---

##   Cómo ejecutar el juego

1. Abrir el proyecto en **NetBeans** (modo consola, usando Ant).
2. Asegurarse de tener las carpetas de código:
src/juegoporturnos/
src/juego/personajes/
src/juego/armitas/

3. Ejecutar la clase principal:
4. Seguir las instrucciones que aparecerán en consola.

---

##   Detalles técnicos y requisitos

- **Lenguaje:** Java 17 o superior.
- **IDE recomendado:** NetBeans (Ant, modo consola).
- **Paradigma:** Programación Orientada a Objetos.
- **Conceptos aplicados:**
- Herencia (`Personaje` como clase base, razas como clases hijas).
- Encapsulamiento y abstracción.
- Polimorfismo en ataques y curaciones.
- Uso de clases auxiliares (`Arma`) para manejo de estadísticas.
- Estructuras de datos para gestión de jugadores y armas.                                        
- **Conexión:** JDBC.

---

##   Descripción del sistema

Este juego simula un combate por turnos entre dos jugadores que eligen raza y arma.  
Cada raza tiene reglas de combate y curación específicas, lo que obliga a planificar la estrategia en cada turno.  
El sistema permite:
- Gestionar ataques con modificadores.
- Aplicar habilidades especiales de cada raza.
- Persistir estadísticas en base de datos.
- Extender fácilmente nuevas razas y armas.

---

##   Roles de los integrantes

- **Integrante 1:** Programación de la estructura base (`Personaje`, `Arma`, menús, control de flujo de turnos).
- **Integrante 2:** Implementación de razas y armas, integración de persistencia con base de datos, pruebas y documentación.

---

##   Capturas de pantalla

  

Ejemplo:
<img width="519" height="416" alt="Screenshot 2025-08-08 215243" src="https://github.com/user-attachments/assets/0299d265-8b8c-42a7-9303-ec5c24b61fa5" />
<img width="634" height="510" alt="Screenshot 2025-08-08 215149" src="https://github.com/user-attachments/assets/67ec77d2-c0e9-467a-8766-f3a0d4d984d4" />
<img width="427" height="237" alt="Screenshot 2025-08-08 215006" src="https://github.com/user-attachments/assets/087534ba-4e13-43b2-bb8b-b0aadee0a570" />
<img width="579" height="540" alt="Screenshot 2025-08-08 203222" src="https://github.com/user-attachments/assets/c4502a98-f43a-4831-9cb1-26a0c3ec741e" />
