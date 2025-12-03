# Foro API Central

Aplicación de foro central con interfaz gráfica Swing.

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/brunoloo/foroapp/
│   │       ├── datatypes/
│   │       │   └── DTUsuario.java
│   │       └── view/
│   │           └── Main.java
│   └── resources/
└── test/
    └── java/
```

## Compilar

```bash
mvn compile
```

## Ejecutar

```bash
mvn exec:java -Dexec.mainClass="com.brunoloo.foroapp.view.Main"
```

O después de empaquetar:

```bash
mvn package
java -jar target/foro-api-central-1.0-SNAPSHOT.jar
```

## Características

- Interfaz gráfica Swing
- Gestión de usuarios (próximamente)
- Sistema de foros (próximamente)