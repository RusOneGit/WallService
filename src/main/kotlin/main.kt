fun main() {
    val post = Post(0, 2, "Привет", 3, 0)
    val post1 = Post(1, 2, "Пока", 3, 0)
    WallService.add(post)
    WallService.viewFromId(1)
    println("Запись добавлена. ID записи: " + post.id)
    WallService.Likes.like(post)
    println("Лайк поставлен. Количество лайков: " + post.likes)
    WallService.Likes.like(post)
    println("Лайк убран. Количество лайков: " + post.likes)
    println(WallService.update(post1))
    WallService.viewFromId(1)


}