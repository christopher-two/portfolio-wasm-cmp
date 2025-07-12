package org.christophertwo.portfolio.ui.components

// Función para obtener la plataforma basada en el título
fun getPlatformFromTitle(title: String): String {
    return when {
        // Casos específicos para proyectos multiplataforma para mayor precisión
        title.contains("Quickness", ignoreCase = true) -> "Multiplatform"
        title.contains("Lerna", ignoreCase = true) -> "Multiplatform"
        title.contains("Eva", ignoreCase = true) -> "Multiplatform"
        title.contains("Calabozos y compuertas", ignoreCase = true) -> "Multiplatform"
        title.contains("Squidgame", ignoreCase = true) -> "Multiplatform"
        title.contains("Color", ignoreCase = true) -> "Multiplatform"

        // Casos específicos para mobile
        title.contains("Lyra", ignoreCase = true) -> "Mobile App"
        title.contains("Lumi", ignoreCase = true) -> "Mobile App"
        title.contains("SquidGames (Version Mobile)", ignoreCase = true) -> "Mobile App"
        title.contains("DragonMatches", ignoreCase = true) -> "Mobile App"

        // Casos generales
        title.contains("Portafolio Daniela Navarro Galeana", ignoreCase = true) -> "Web"
        title.contains("Eikocolors", ignoreCase = true) -> "Web"
        title.contains("Fuente", ignoreCase = true) -> "Web"
        title.contains("Danonino", ignoreCase = true) -> "Web"
        title.contains("Asian", ignoreCase = true) -> "Web"
        title.contains("App", ignoreCase = true) -> "Mobile App"
        title.contains("web", ignoreCase = true) -> "Web"
        title.contains("Desktop", ignoreCase = true) -> "Desktop"
        title.contains("KMP", ignoreCase = true) -> "Multiplatform"
        else -> "Web" // Valor por defecto
    }
}

// Función para obtener información detallada del proyecto
fun getProjectDetails(title: String): Pair<String, List<String>> {
    return when {
        title.contains("Quickness", ignoreCase = true) -> Pair(
            "Quickness es un sistema innovador diseñado para modernizar y centralizar la gestión de todo tipo de accesos. Ofrece una solución segura, eficiente y fácil de usar para una amplia gama de aplicaciones, incluyendo edificios corporativos, eventos masivos, gimnasios, zonas residenciales, estacionamientos, servicios exclusivos y transporte público. Quickness unifica el control de acceso bajo una misma plataforma, transformando la gestión de accesos en una experiencia más confiable, segura, inteligente y ágil.",
            listOf(
                "Compose Multiplatform", "Room", "Datastore", "Koin", "Ktor", "Firebase",
                "Gemini Api", "Biometric", "Moko Permissions", "Coil", "MVVM",
                "Clean Architecture", "Multimodularity", "Layered Model", "Repository Pattern", "DeepLinks"
            )
        )
        title.contains("Lerna", ignoreCase = true) -> Pair(
            "Plataforma que ofrece diversas herramientas digitales para mejorar la productividad y eficiencia de los profesores en la enseñanza.",
            listOf(
                "Compose Multiplatform (Desktop & Wasm)", "Koin", "Ktor", "Coil", "Firebase", "Classroom API",
                "Backend (Ktor)", "Docker", "Google Cloud Functions", "Gemini API", "MVVM",
                "Clean Architecture", "Multimodularity", "Layered Model", "Repository Pattern"
            )
        )
        title.contains("Lyra", ignoreCase = true) -> Pair(
            "Un ecosistema integral diseñado para mejorar y optimizar la práctica de los profesionales de la nutrición, ofreciendo una solución completa que va más allá de una simple aplicación de nutrición.",
            listOf(
                "Jetpack Compose", "Room", "Datastore", "Koin", "Ktor", "Coil", "Firebase",
                "Backend (Ktor)", "Docker", "Google Cloud Functions", "Gemini API", "MVVM",
                "DeepLinks", "Clean Architecture", "Multimodularity", "Layered Model", "Repository Pattern"
            )
        )
        title.contains("Calabozos y compuertas", ignoreCase = true) -> Pair(
            "Calabozos y Compuertas Mobile es una aplicación diseñada para llevar la emoción y la lógica de los juegos de calabozos y el funcionamiento de las compuertas lógicas a tu dispositivo móvil. La aplicación parece estar dividida en varios módulos, incluyendo un libro de runas, un libro de lógica y un controlador, lo que sugiere una rica interacción y contenido educativo o de juego.",
            listOf(
                "Compose Multiplatform", "Koin", "Ktor", "Coil", "MVVM",
                "Clean Architecture", "Multimodularity", "Layered Model", "Repository Pattern"
            )
        )
        title.contains("Portafolio Daniela Navarro Galeana", ignoreCase = true) -> Pair(
            "Esta página web presenta el perfil de Daniela Navarro Galeana, una estudiante de Comercio Internacional y Aduanas. El contenido cubre su experiencia profesional, formación académica y habilidades, incluyendo el período actual en el que se encuentra cursando sus estudios.",
            listOf("TypeScript", "React", "Tailwind CSS", "Next.js", "Firebase Hosting")
        )
        title.contains("Eikocolors", ignoreCase = true) -> Pair(
            "Web hecha para empresa de diseño gráfico, exponiendo sus trabajos y servicios.",
            listOf("TypeScript", "React", "Tailwind CSS", "Next.js", "Firebase Hosting")
        )
        title.contains("Fuente", ignoreCase = true) -> Pair(
            "Web hecha para mostrar los videos del día del padre hechos por sus hijos, fue hecha para un kinder.",
            listOf("React", "Vite", "CSS")
        )
        title.contains("Danonino", ignoreCase = true) -> Pair(
            "Web hecha para mi novia bonita.",
            listOf("React", "CSS", "Vite")
        )
        title.contains("Eva", ignoreCase = true) -> Pair(
            "Librería multiplataforma hecha para experimentar con las funcionalidades de la IA EVA, principalmente para crear componentes para otros proyectos como Lyra o Lerna.",
            listOf("Compose Multiplatform (Android, iOS, Wasm, Desktop)", "Gemini API")
        )
        title.contains("Lumi", ignoreCase = true) -> Pair(
            "Lumi es una herramienta inteligente que democratiza la creación y el escaneo de códigos QR. Aprovecha la potencia de la API de Gemini para transformar ideas en códigos QR visualmente impactantes y funcionalmente robustos, todo desde el dispositivo del usuario.",
            listOf("Jetpack Compose", "Gemini API", "QR-Rose", "MVVM", "Clean Architecture", "Repository Pattern")
        )
        title.contains("Squidgame", ignoreCase = true) -> Pair(
            "El objetivo general de este proyecto es diseñar, desarrollar e implementar un sistema embebido interactivo que simule de manera funcional y atractiva el juego del \"Puente de Cristal\", inspirado en la serie \"El Juego del Calamar\", buscando destacar entre otros proyectos por su nivel de integración y calidad.",
            listOf("Compose Multiplatform", "JVM", "Wasm", "Firebase Realtime", "Firebase Firestore")
        )
        title.contains("SquidGames (Version Mobile)", ignoreCase = true) -> Pair(
            "El objetivo general de este proyecto es diseñar, desarrollar e implementar un sistema embebido interactivo que simule de manera funcional y atractiva el juego del \"Puente de Cristal\", inspirado en la serie \"El Juego del Calamar\", buscando destacar entre otros proyectos por su nivel de integración y calidad.",
            listOf("Jetpack Compose", "TensorFlow", "Koin", "Ktor", "Firebase Realtime", "Firebase Firestore")
        )
        title.contains("Color", ignoreCase = true) -> Pair(
            "Juego de escritorio para adivinar colores RGB. Entrena la percepción visual del color con diferentes niveles de dificultad.",
            listOf("Compose Multiplatform JVM")
        )
        title.contains("DragonMatches", ignoreCase = true) -> Pair(
            "Una app inspirada en el Dragonball con una tematica de tinder, se explora el uso de el swipe de tinder, ademas de que es funcional conectando con la api de dragonball.",
            listOf("Koin", "Ktor", "Coil", "Jetpack Compose")
        )
        title.contains("Asian", ignoreCase = true) -> Pair(
            "Línea de tiempo interactiva del crecimiento económico asiático. Visualización de datos históricos y proyecciones futuras.",
            listOf("TypeScript", "React", "Tailwind CSS", "Next.js", "Firebase Hosting")
        )
        else -> Pair(
            "Próximamente...",
            listOf()
        )
    }
}

// Función para obtener imágenes del proyecto
fun getProjectImages(title: String): List<String> {
    return when {
        title.contains("Quickness", ignoreCase = true) -> listOf(
            "https://vluoppbaehfmhkebyygv.supabase.co/storage/v1/object/public/proyectos//Quickness_Wallpaper.png"
        )
        title.contains("Lerna", ignoreCase = true) -> listOf(
            "https://images.unsplash.com/photo-1551650975-87deedd944c3?w=600&h=400&fit=crop",
            "https://images.unsplash.com/photo-1460925895917-afdab827c52f?w=600&h=400&fit=crop",
            "https://images.unsplash.com/photo-1552664730-d307ca884978?w=600&h=400&fit=crop"
        )
        title.contains("Lyra", ignoreCase = true) -> listOf(
            "https://images.unsplash.com/photo-1493612276216-ee3925520721?w=600&h=400&fit=crop",
            "https://images.unsplash.com/photo-1470225620780-dba8ba36b745?w=600&h=400&fit=crop",
            "https://images.unsplash.com/photo-1571974599782-87614810e5db?w=600&h=400&fit=crop"
        )
        else -> listOf(
            "https://images.unsplash.com/photo-1461749280684-dccba630e2f6?w=600&h=400&fit=crop",
            "https://images.unsplash.com/photo-1555066931-4365d14bab8c?w=600&h=400&fit=crop",
            "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?w=600&h=400&fit=crop"
        )
    }
}