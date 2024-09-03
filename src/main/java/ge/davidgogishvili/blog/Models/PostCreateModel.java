package ge.davidgogishvili.blog.Models;

public record PostCreateModel(


        String title,

        String content,

        String category,

        String subCategory
) {
}
