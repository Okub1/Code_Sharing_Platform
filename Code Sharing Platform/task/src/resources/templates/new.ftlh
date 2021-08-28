<html>
<head>
   <title>Create</title>
   </head>
<body>
    <style>
        textarea {
            width: 700px;
            height: 300px;
        }
    </style>

    <script>
    function send() {
    let object = {
        "code": document.getElementById("code_snippet").value,
        "time": document.getElementById("time_restriction").value,
        "views": document.getElementById("views_restriction").value
    };

    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/code/new', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);
}
    </script>
    <div>
        <textarea id="code_snippet"> // write your code here </textarea>
        <br>
        <div>
            <br>
            Time restriction: <input id="time_restriction" type="text" value="0"/> (0 for unlimited)
            <br>
            <br>
            Views restriction: <input id="views_restriction" type="text" value="0"/> (0 for unlimited)
        </div>

        <br>
        <button id="send_snippet" type="submit" onclick="send()">Submit</button>
    </div>
</body>
</html>
