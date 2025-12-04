# foro-api-central
El sistema a desarrollar será una plataforma web, denominada [pensar_nombre], que brindará soporte a un espacio libre de opinión. 

Permitirá que sus usuarios registrados abran temas de conversación dentro de categorías temáticas, y que otros usuarios puedan sumarse a dichos temas mediante comentarios y respuestas encadenadas.

A aquellos usuarios que naveguen sin registrarse, podrán acceder a los diferentes contenidos de la plataforma sin la posibilidad de participar de forma activa. Las interacciones entre usuarios requerirán un registro.

# visión
La plataforma [nombre] es un espacio web orientado a la libre expresión y el intercambio de ideas entre usuarios. Su propósito es ofrecer un entorno simple, accesible y centrado en la conversación, donde las personas puedan debatir, opinar y compartir contenido de forma organizada.

Para utilizar las funcionalidades disponibles, los usuarios deben registrarse proporcionando su nickname dentro de la plataforma, junto con su nombre, correo electrónico y contraseña. El nickname y correo electrónico son únicos dentro del sistema. De manera opcional se puede agregar una biografía junto con una foto de portada y banner.
Se registra la fecha de alta del usuario en el sistema. Los usuarios pueden seguir a otros usuarios para mantenerse al tanto de su actividad.

La plataforma organiza su contenido en categorías, creadas por usuarios registrados. Un usuario registrado puede crear múltiples categorías. Cada categoría representa un tema principal, que es asignado por su autor. De cada categoría interesa saber su título (único), autor, fecha de creación, estado (activa, inactiva) y descripción obligatoria. 
Los usuarios pueden crear temas relacionados dentro de la categoría. De cada tema interesa saber su título (único dentro de la categoría), contenido, autor, fecha de creación, estado (activo, inactivo), y categoría a la que pertenece.

Los usuarios pueden participar activamente mediante comentarios dentro de cada tema, los comentarios pueden ser respuestas directas al tema o respuestas a otros comentarios, permitiendo conversaciones encadenadas. De cada comentario interesa saber su contenido, autor, fecha de creación, estado (visible, oculto) y, opcionalmente, el comentario que responde. 

Los usuarios pueden reportar comentarios o temas por motivos de spam o incitación al odio. De cada reporte interesa saber el comentario reportado, usuario que reporta, motivo y la fecha del reporte.
Cuando un comentario o tema pasa a estado oculto, su autor puede iniciar una apelación. De cada apelación interesa saber el comentario apelado, la justificación del autor, la fecha de solicitud, el estado (pendiente, aceptada, rechazada) y, en caso de resolución, el administrador que la evaluó y la fecha de resolución.

La plataforma permite que los usuarios expresen su opinión sobre los contenidos mediante reacciones: “me gusta”, “no me gusta”, “interesante” o “gracioso”. 
Cada usuario puede realizar una única reacción por tema o comentario, con la posibilidad de quitar o cambiar su reacción posteriormente.
De cada reacción interesa saber el tipo de reacción, autor y tema o comentario que pertenece.

# políticas del sistema 

1. [Categoría]
   • Los usuarios autores de categorías obtendrán el rol de moderador de la categoría creada. 
   • Los usuarios que participen (creando temas o comentarios), obtendrán el rol de participante.
   • Los moderadores pueden acceder a la lista de participantes de su categoría.
   • Los moderadores pueden eliminar su categoría, la cual pasará a estado [inactiva].
   • Las categorías en estado [inactiva] no permitirán la publicación de contenido. 
     El contenido previo a su inactivación permanecerá visible. 
   • La descripción de una categoría podrá ser editada por su moderador máximo una vez cada 72 horas.
   • La descripción de una categoría tendrá un historial de ediciones visible.
   • Cada categoría muestra un contador visible de comentarios publicados (incluyendo respuestas).

2. [Tema]
   • Solo el autor puede eliminar su propio tema, el cual pasará a estado [inactivo].
   • Los usuarios pueden reportar un tema por spam o incitación al odio.
   • Si un tema supera un umbral de reportes, pasará a estado [inactivo]. 
   • Los temas en estado [inactivo] no permitirán la publicación de contenido. 
     El contenido previo a su inactivación permanecerá visible.

3. [Comentarios]
   • Los comentarios se publicarán de forma inmediata en estado [visible]. 
   • Solo el autor puede eliminar su propio comentario. 
   • Los usuarios pueden reportar un comentario por spam o incitación al odio. 
   • Si un comentario supera un umbral de reportes, pasará a estado [oculto]. 
   • El autor puede editar su comentario, manteniendo un historial de ediciones visible.

4. [Reportes]
   • Cada usuario puede reportar una única vez un mismo comentario o tema. 

5. [Apelaciones]
   • El autor de un comentario [oculto] podrá realizar una apelación para que vuelva a 
     estado [visible]. Ésta será evaluada por un administrador del sistema.
   • El autor de un tema [inactivo] podrá realizar una apelación para que vuelva a 
     estado [activo]. Ésta será evaluada por un administrador del sistema. 

# -- updates --
A futuro, la plataforma podrá incorporar funcionalidades adicionales como marcación de temas favoritos, estadísticas de interacción, reputación de usuarios o recomendaciones personalizadas.
Habrá un ranking de comentarios mejores valorados. 

