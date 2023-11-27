package pigking.boardservice.domain.article;

import lombok.Data;

@Data
public class Article {
    private Long articleId;
    private String title;
    private String content;

    public Article() {
    }

    public Article( String title, String content) {
        this.title = title;
        this.content = content;
    }
}
