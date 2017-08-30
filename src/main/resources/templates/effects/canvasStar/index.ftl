<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        html, body {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
            background: black;
            background: linear-gradient(to bottom, #dcdcdc 0%, Gold 100%);
        }

        #main-canvas {
            width: 100%;
            height: 100%;
        }

        .filter {
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            background: #FFD700;
            animation: colorChange 30s ease-in-out infinite;
            animation-fill-mode: both;
            mix-blend-mode: overlay;

        }

        @keyframes colorChange {
            0%, 100% {
                opacity: 0;
            }
            50% {
                opacity: .7;
            }
        }
    </style>

</head>
<body>
<canvas id="canvas"></canvas>

<script src="/js/canvasstar.js"></script>
<script>
    var CanvasStar = new CanvasStar;
    CanvasStar.init();
</script>
</body>
</html>