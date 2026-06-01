🏦 Motor Financiero - Simulador Hipotecario (Backend)
API RESTful desarrollada en Java y Spring Boot que actúa como motor de cálculo financiero. Implementa el algoritmo del Sistema de Amortización Francés para calcular cuotas hipotecarias fijas y generar cuadros de amortización detallados mes a mes.

🚀 Arquitectura y Tecnologías
Lenguaje: Java 21

Framework: Spring Boot 3 (Web)

Arquitectura: Patrón Controller-Service-DTO (Data Transfer Objects con records de Java).

Endpoints: API REST expuesta para consumo desde el frontend.

Cálculo: Algoritmos de precisión matemática para interés compuesto y amortización.

⚙️ Guía de Ejecución Rápida
Este microservicio está configurado para ejecutarse de forma independiente en un puerto específico para no interferir con otras aplicaciones.

Prerrequisitos
Java JDK 17 o superior.

Maven instalado (o usar el wrapper incluido).

1. Clonar el repositorio
Abre tu terminal y ejecuta:

git clone https://github.com/josemanueldg02-star/hipoteca-simulador.git
cd hipoteca-simulador

2. Levantar el Servidor Spring Boot
Puedes compilar y ejecutar el proyecto usando el wrapper de Maven directamente desde la terminal:

./mvnw spring-boot:run

(El servidor se levantará en el puerto dedicado: http://localhost:8083 y quedará a la espera de peticiones POST en /api/hipoteca/calcular).