package pigking.boardservice.domain.article;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ArticleRepositoryTest {

    ArticleRepository articleRepository = new ArticleRepository();

    @AfterEach
    void afterEach() {
        articleRepository.clearStore();
    }

    @Test
    @DisplayName("글 저장하기 단위 테스트")
    void save() {
        // given
        Article article = new Article("테스트 글입니다", "개발자 취업 쉽지 않군요...뭐가 문제일까요...?");

        // when
        Article savedArticle = articleRepository.save(article);

        // then
        Article findArticle = articleRepository.findById(article.getArticleId());
        Assertions.assertThat(findArticle).isEqualTo(savedArticle);

    }

    @Test
    @DisplayName("글 목록 가져오기 단위 테스트")
    void findAll() {
        // given
        Article article1 = new Article("테스트 글1", "테스트 1 글입니다.");
        Article article2 = new Article("테스트 글2", "테스트 2 글입니다.");

        articleRepository.save(article1);
        articleRepository.save(article2);

        // when
        List<Article> result = articleRepository.findAll();

        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(article1, article2);

    }

    @Test
    @DisplayName("글 수정하기 단위 테스트")
    void updateArticle() {
        // given
        Article article = new Article("article1", "테스트 글입니다.");

        Article savedArticle = articleRepository.save(article);
        Long articleId = savedArticle.getArticleId();

        // when
        Article updateParam = new Article("article2", "테스트 글 2입니다.");
        articleRepository.update(articleId, updateParam);

        Article findArticle = articleRepository.findById(articleId);

        // then
        Assertions.assertThat(findArticle.getContent()).isEqualTo(updateParam.getContent());
        Assertions.assertThat(findArticle.getTitle()).isEqualTo(updateParam.getTitle());

    }


}