fun main() {
    val post = Post(0, text = "Привет")
    val post1 = Post(0,text = "Пока")
    val post3 = Post(0)
    println( WallService.add(post))
    println(WallService.add(post1))
    println(WallService.add(post3))

    println(WallService.View.view(post1))
    println(WallService.View.view(post1))
    println(WallService.View.view(post1))
    println(WallService.View.view(post1))






}