<html>
<head>
    <title>Latest</title>

    <link rel="stylesheet"
          target="_blank" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>

    <style>
        .date {
            color: green;
            font-family: Consolas, monospace;
        }

        .code {
            border: solid 1px grey;
            width: 750px;
            background-color: WhiteSmoke;
        }
    </style>
</head>
<body>

<div>
    <#list codes as item>
        <div class="date">
                <span id="load_date">
                    ${item.date}
                </span>
        </div>
        <div class="code">
                <pre id="code_snippet">
                    <code>
                        ${item.code}
                    </code>
                </pre>
        </div>
    <br>
    </#list>
</div>
</body>
</html>