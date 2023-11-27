package pigking.boardservice.domain.article;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ArticleRepository {
    private static final Map<Long, Article> board = new HashMap<>(); // static 사용
    private static long sequence = 0L;

    // 게시글 저장
    public Article save(Article article) {
        article.setArticleId(++sequence);
        board.put(article.getArticleId(), article);
        return article;
    }

    // 게시글 찾기
    public Article findById(Long articleId) {
        return board.get(articleId);
    }

    // 게시글 리스트 보기
    public List<Article> findAll() {
        return new ArrayList<>(board.values());
    }

    // 게시글 수정
    public void update(Long articleId, Article updateParam) {
        Article findArticle = findById(articleId);
        findArticle.setTitle(updateParam.getTitle());
        findArticle.setContent(updateParam.getContent());
    }

    public void clearStore() {
        board.clear();
    }

}
