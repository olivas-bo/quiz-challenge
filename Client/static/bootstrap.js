(function (e, a, g, h, f, c, b, d) {
    if (!(f = e.jQuery) || g > f.fn.jquery || h(f)) {
        c = a.createElement("script");
        c.type = "text/javascript";
        c.src = "http://ajax.googleapis.com/ajax/libs/jquery/" + g + "/jquery.min.js";
        c.onload = c.onreadystatechange = function () {
            if (!b && (!(d = this.readyState) || d == "loaded" || d == "complete")) {
                h((f = e.jQuery).noConflict(1), b = 1);
                f(c).remove()
            }
        };
        a.documentElement.childNodes[0].appendChild(c)
    }
})(window, document, "1.3.2", function ($, L) {

    //your code here (a div with some content)
    $("<div style='width:500px;height:400px; border:1px solid black; background-color:white; position:fixed; top: 0; right:0; z-index:99999'><iframe src='http://localhost:3000/' width='100%' height='100%' style='overflow-x:hidden;border:none'></div>").appendTo("body");
})