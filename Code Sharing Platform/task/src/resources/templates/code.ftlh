<html>
<head>
    <title>Code</title>

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
    <#if code.views gte 0>
        <span id="views_restriction">${code.views} more views allowed</span>
    </#if>
    <#if code.time gt 0>
        <span id="time_restriction">The code will be available for ${duration} seconds</span>
    </#if>
    <div class="date">
            <span id="load_date">
                ${code.date}
            </span>
    </div>
    <div class="code">
            <pre id="code_snippet">
                <code>
                    ${code.code}
                </code>
            </pre>
    </div>
</div>
</body>
</html>