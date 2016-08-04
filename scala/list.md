###Scala for循环

    for(p <- persons; n = p.name; if (n startsWith "To")) {
        println(n)
    }
    
其中变量n相当于`val n = p.name` 