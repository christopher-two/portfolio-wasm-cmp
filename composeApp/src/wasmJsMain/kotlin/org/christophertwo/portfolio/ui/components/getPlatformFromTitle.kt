package org.christophertwo.portfolio.ui.components

// Función para obtener la plataforma basada en el título
fun getPlatformFromTitle(title: String): String {
    return when {
        title.contains("App", ignoreCase = true) -> "Mobile App"
        title.contains("web", ignoreCase = true) -> "Web"
        title.contains("Desktop", ignoreCase = true) -> "Desktop"
        title.contains("KMP", ignoreCase = true) -> "Multiplatform"
        else -> "Web"
    }
}

// Función para obtener información detallada del proyecto
fun getProjectDetails(title: String): Pair<String, List<String>> {
    return when {
        title.contains("Quickness", ignoreCase = true) -> Pair(
            "Aplicación móvil para gestión de tareas rápidas y eficientes. Permite crear, organizar y completar tareas con una interfaz intuitiva y moderna.",
            listOf("Kotlin", "Jetpack Compose", "Room", "Coroutines", "Material Design")
        )
        title.contains("Lerna", ignoreCase = true) -> Pair(
            "Plataforma de gestión de proyectos colaborativos. Facilita la coordinación entre equipos con herramientas de seguimiento y comunicación.",
            listOf("React", "Node.js", "MongoDB", "Express", "Socket.io")
        )
        title.contains("Lyra", ignoreCase = true) -> Pair(
            "Aplicación de reproducción musical con funciones avanzadas de gestión de biblioteca y recomendaciones personalizadas.",
            listOf("Flutter", "Dart", "Firebase", "Audio Players", "Material Design")
        )
        title.contains("Calabozos", ignoreCase = true) -> Pair(
            "Juego de rol digital inspirado en Dungeons & Dragons. Incluye creación de personajes, sistema de combate y narrativa interactiva.",
            listOf("Unity", "C#", "SQLite", "Photon", "DOTween")
        )
        title.contains("Portfolio", ignoreCase = true) -> Pair(
            "Sitio web profesional showcasing para desarrolladora frontend. Diseño responsive con animaciones y portfolio interactivo.",
            listOf("HTML5", "CSS3", "JavaScript", "SASS", "Webpack")
        )
        title.contains("Eikocolors", ignoreCase = true) -> Pair(
            "Herramienta web para generación y gestión de paletas de colores. Incluye extractor de colores de imágenes y generador de esquemas.",
            listOf("Vue.js", "Nuxt.js", "TailwindCSS", "Canvas API", "PWA")
        )
        title.contains("Fuente", ignoreCase = true) -> Pair(
            "Plataforma educativa online con cursos interactivos y sistema de evaluación. Enfocada en aprendizaje personalizado.",
            listOf("Angular", "TypeScript", "Firebase", "RxJS", "Angular Material")
        )
        title.contains("Danonino", ignoreCase = true) -> Pair(
            "Sitio web promocional interactivo para productos infantiles. Incluye juegos educativos y contenido para padres.",
            listOf("React", "Three.js", "GSAP", "Styled Components", "Storybook")
        )
        title.contains("Eva", ignoreCase = true) -> Pair(
            "Aplicación multiplataforma para gestión de salud personal. Seguimiento de medicamentos, citas médicas y recordatorios.",
            listOf("Kotlin Multiplatform", "Compose Multiplatform", "SQLDelight", "Ktor", "Koin")
        )
        title.contains("QR", ignoreCase = true) -> Pair(
            "Generador y lector de códigos QR con funciones avanzadas. Soporte para múltiples formatos y personalización visual.",
            listOf("Android", "Kotlin", "CameraX", "ML Kit", "Material You")
        )
        title.contains("Squid", ignoreCase = true) -> Pair(
            "Juego interactivo basado en la serie Squid Game. Incluye múltiples mini-juegos y sistema de puntuación global.",
            listOf("JavaScript", "Canvas API", "WebGL", "Socket.io", "Express")
        )
        title.contains("Color", ignoreCase = true) -> Pair(
            "Juego de escritorio para adivinar colores RGB. Entrena la percepción visual del color con diferentes niveles de dificultad.",
            listOf("Electron", "JavaScript", "CSS3", "Node.js", "Chart.js")
        )
        title.contains("Dragon", ignoreCase = true) -> Pair(
            "Juego de estrategia por turnos con temática de dragones. Incluye sistema de cartas y batallas tácticas.",
            listOf("Flutter", "Dart", "Flame Engine", "Hive", "Provider")
        )
        title.contains("Asian", ignoreCase = true) -> Pair(
            "Línea de tiempo interactiva del crecimiento económico asiático. Visualización de datos históricos y proyecciones futuras.",
            listOf("D3.js", "React", "TypeScript", "Recharts", "Framer Motion")
        )
        else -> Pair(
            "Proyecto de desarrollo de software con enfoque en soluciones innovadoras y experiencia de usuario excepcional.",
            listOf("JavaScript", "React", "Node.js", "CSS3", "HTML5")
        )
    }
}

// Función para obtener imágenes del proyecto
fun getProjectImages(title: String): List<String> {
    return when {
        title.contains("Quickness", ignoreCase = true) -> listOf(
            "https://images.unsplash.com/photo-1556742049-0cfed4f6a45d?w=600&h=400&fit=crop",
            "https://images.unsplash.com/photo-1611224923853-80b023f02d71?w=600&h=400&fit=crop",
            "https://images.unsplash.com/photo-1563013544-824ae1b704d3?w=600&h=400&fit=crop"
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