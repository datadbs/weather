package zb.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zb.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class JpaMemoRepository {
    @Autowired
    JpaMemoRepository jpaMemoRepository;
    @Test
    void insertMemoTest(){
        Memo newMemo = new Memo(10,"this is jpa memo");
        jpaMemoRepository.save(newMemo);

        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() >0 );
    }

    void findByIdTest(){
        Memo newMemo = new Memo(11, "jpa");
        Memo memo = jpaMemoRepository.save(newMemo);
        System.out.println(memo.getId());
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
        assertEquals(result.get().getText(), "jpa");
    }
}
