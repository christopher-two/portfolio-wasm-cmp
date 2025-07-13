package org.christophertwo.portfolio.utils;

enum class ProjectEnum(
    val title: String,
    val uri: String,
    val platform: String,
    val description: String,
    val technologies: List<String>,
    val image: String,
    val type: ProjectType
) {
    // Proyectos Profesionales
    QUICKNESS_APP(
        title = "Quickness",
        uri = "https://christopher.com.mx/quickness",
        platform = "Multiplatform",
        description = "Quickness es un sistema innovador diseñado para modernizar y centralizar la gestión de todo tipo de accesos. Ofrece una solución segura, eficiente y fácil de usar para una amplia gama de aplicaciones, incluyendo edificios corporativos, eventos masivos, gimnasios, zonas residenciales, estacionamientos, servicios exclusivos y transporte público. Quickness unifica el control de acceso bajo una misma plataforma, transformando la gestión de accesos en una experiencia más confiable, segura, inteligente y ágil.",
        technologies = listOf(
            "Compose Multiplatform",
            "Room",
            "Datastore",
            "Koin",
            "Ktor",
            "Firebase",
            "Gemini Api",
            "Biometric",
            "Moko Permissions",
            "Coil",
            "MVVM",
            "Clean Architecture",
            "Multimodularity",
            "Layered Model",
            "Repository Pattern",
            "DeepLinks"
        ), // AQUI
        image = "https://vluoppbaehfmhkebyygv.supabase.co/storage/v1/object/public/proyectos//Quickness_Wallpaper.png",
        type = ProjectType.PROFESSIONAL
    ),
    LERNA_APP(
        title = "Lerna",
        uri = "https://christopher.com.mx/lerna",
        platform = "Multiplatform",
        description = "Plataforma que ofrece diversas herramientas digitales para mejorar la productividad y eficiencia de los profesores en la enseñanza.",
        technologies = listOf(
            "Compose Multiplatform (Desktop & Wasm)",
            "Koin",
            "Ktor",
            "Coil",
            "Firebase",
            "Classroom API",
            "Backend (Ktor)",
            "Docker",
            "Google Cloud Functions",
            "Gemini API",
            "MVVM",
            "Clean Architecture",
            "Multimodularity",
            "Layered Model",
            "Repository Pattern"
        ),
        image = "https://images.unsplash.com/photo-1551650975-87deedd944c3?w=600&h=400&fit=crop",
        type = ProjectType.PROFESSIONAL
    ),
    LYRA_APP(
        title = "Lyra",
        uri = "https://christopher.com.mx/lyra",
        platform = "Mobile App",
        description = "Un ecosistema integral diseñado para mejorar y optimizar la práctica de los profesionales de la nutrición, ofreciendo una solución completa que va más allá de una simple aplicación de nutrición.",
        technologies = listOf(
            "Jetpack Compose",
            "Room",
            "Datastore",
            "Koin",
            "Ktor",
            "Coil",
            "Firebase",
            "Backend (Ktor)",
            "Docker",
            "Google Cloud Functions",
            "Gemini API",
            "MVVM",
            "DeepLinks",
            "Clean Architecture",
            "Multimodularity",
            "Layered Model",
            "Repository Pattern"
        ),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PROFESSIONAL
    ),
    CALABOZOS_COMPUERTAS_APP(
        title = "Calabozos y compuertas",
        uri = "https://christopher.com.mx/calabozoscompuertas",
        platform = "Multiplatform",
        description = "Calabozos y Compuertas Mobile es una aplicación diseñada para llevar la emoción y la lógica de los juegos de calabozos y el funcionamiento de las compuertas lógicas a tu dispositivo móvil. La aplicación parece estar dividida en varios módulos, incluyendo un libro de runas, un libro de lógica y un controlador, lo que sugiere una rica interacción y contenido educativo o de juego.",
        technologies = listOf(
            "Compose Multiplatform", "Koin", "Ktor", "Coil", "MVVM",
            "Clean Architecture", "Multimodularity", "Layered Model", "Repository Pattern"
        ),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PROFESSIONAL
    ),
    PORTFOLIO_DANIELA(
        title = "Portafolio Daniela Navarro Galeana",
        uri = "https://daniela-navarro-galeana.web.app",
        platform = "Web",
        description = "Esta página web presenta el perfil de Daniela Navarro Galeana, una estudiante de Comercio Internacional y Aduanas. El contenido cubre su experiencia profesional, formación académica y habilidades, incluyendo el período actual en el que se encuentra cursando sus estudios.",
        technologies = listOf("TypeScript", "React", "Tailwind CSS", "Next.js", "Firebase Hosting"),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PROFESSIONAL
    ),
    EIKOCOLORS_WEB(
        title = "Eikocolors",
        uri = "https://eikocolors.web.app",
        platform = "Web",
        description = "Web hecha para empresa de diseño gráfico, exponiendo sus trabajos y servicios.",
        technologies = listOf("TypeScript", "React", "Tailwind CSS", "Next.js", "Firebase Hosting"),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PROFESSIONAL
    ),
    LA_FUENTE_SABER(
        title = "Fuente",
        uri = "https://fuente-saber.web.app/",
        platform = "Web",
        description = "Web hecha para mostrar los videos del día del padre hechos por sus hijos, fue hecha para un kinder.",
        technologies = listOf("React", "Vite", "CSS"),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PROFESSIONAL
    ),

    // Proyectos Personales
    QR_APP(
        title = "Lumi",
        uri = "https://christopher.com.mx/lumi",
        platform = "Mobile App",
        description = "Lumi es una herramienta inteligente que democratiza la creación y el escaneo de códigos QR. Aprovecha la potencia de la API de Gemini para transformar ideas en códigos QR visualmente impactantes y funcionalmente robustos, todo desde el dispositivo del usuario.",
        technologies = listOf(
            "Jetpack Compose",
            "Gemini API",
            "QR-Rose",
            "MVVM",
            "Clean Architecture",
            "Repository Pattern"
        ),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PERSONAL
    ),
    DANONINO_WEB(
        title = "Danonino",
        uri = "https://christopher.com.mx/danonino",
        platform = "Web",
        description = "Web hecha para mi novia bonita.",
        technologies = listOf("React", "CSS", "Vite"),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PERSONAL
    ),
    EVA_KMP(
        title = "Eva",
        uri = "https://eva.override.com.mx",
        platform = "Multiplatform",
        description = "Librería multiplataforma hecha para experimentar con las funcionalidades de la IA EVA, principalmente para crear componentes para otros proyectos como Lyra o Lerna.",
        technologies = listOf("Compose Multiplatform (Android, iOS, Wasm, Desktop)", "Gemini API"),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PERSONAL
    ),
    SQUID_GAME(
        title = "Squidgame",
        uri = "https://christopher.com.mx/squidgame",
        platform = "Multiplatform",
        description = "El objetivo general de este proyecto es diseñar, desarrollar e implementar un sistema embebido interactivo que simule de manera funcional y atractiva el juego del \"Puente de Cristal\", inspirado en la serie \"El Juego del Calamar\", buscando destacar entre otros proyectos por su nivel de integración y calidad.",
        technologies = listOf(
            "Compose Multiplatform",
            "JVM",
            "Wasm",
            "Firebase Realtime",
            "Firebase Firestore"
        ),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PERSONAL
    ),
    ADIVINA_COLOR_RGB_DESKTOP(
        title = "Color",
        uri = "https://christopher.com.mx/adivina-color-rgb",
        platform = "Multiplatform",
        description = "Juego de escritorio para adivinar colores RGB. Entrena la percepción visual del color con diferentes niveles de dificultad.",
        technologies = listOf("Compose Multiplatform JVM"),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PERSONAL
    ),
    DRAGON_MATCHES_APP(
        title = "DragonMatches",
        uri = "https://christopher.com.mx/dragon-matches",
        platform = "Mobile App",
        description = "Una app inspirada en el Dragonball con una tematica de tinder, se explora el uso de el swipe de tinder, ademas de que es funcional conectando con la api de dragonball.",
        technologies = listOf("Koin", "Ktor", "Coil", "Jetpack Compose"),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PERSONAL
    ),
    ASIAN_TIMELINE_WEB(
        title = "Asian",
        uri = "https://asian-growth-timeline.web.app/",
        platform = "Web",
        description = "Línea de tiempo interactiva del crecimiento económico asiático. Visualización de datos históricos y proyecciones futuras.",
        technologies = listOf("TypeScript", "React", "Tailwind CSS", "Next.js", "Firebase Hosting"),
        image = "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop",
        type = ProjectType.PERSONAL
    );

    companion object {
        fun getProjectsByType(type: ProjectType): List<ProjectEnum> {
            return entries.filter { it.type == type }
        }

        fun getAllProjects(): List<ProjectEnum> {
            return entries.toList()
        }
    }
}
