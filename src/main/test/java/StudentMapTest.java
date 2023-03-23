import com.endava.internship.collections.Student;
import com.endava.internship.collections.StudentMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentMapTest {

    StudentMap studentMap;
    StudentData studentData = new StudentData();

    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;

    private final Student student1 = studentData.student1;
    private final Student student2 = studentData.student2;
    private final Student student3 = studentData.student3;


    @BeforeEach
    public void setUp() {
        studentMap = new StudentMap(13);
    }

    @Test
    public void put_WhenEnteredValue_returnPutValue() {

        Integer firstValue = studentMap.put(studentData.student1, 1);
        Integer secondValue = studentMap.put(studentData.student2, 2);
        Integer thirdValue = studentMap.put(studentData.student3, 3);


        assertThat(firstValue).isEqualTo(ONE);
        assertThat(secondValue).isEqualTo(TWO);
        assertThat(thirdValue).isEqualTo(THREE);
    }

    @Test
    public void put_WhenThePutValueIsEqualWith_get_returnPutValue() {
        studentMap.put(studentData.student1, 1);
        studentMap.put(studentData.student2, 2);
        studentMap.put(studentData.student3, 3);
        studentMap.put(studentData.student4, 4);

        assertThat(studentMap.get(studentData.student1)).isEqualTo(ONE);
        assertThat(studentMap.get(studentData.student2)).isEqualTo(TWO);
        assertThat(studentMap.get(studentData.student3)).isEqualTo(THREE);

    }

    @Test
    public void put_WhenTheDuplicateKey_returnLastPuttedValueByDuplicatedKey() {

        studentMap.put(student1, 1);
        assertThat(studentMap.get(student1)).isEqualTo(1);

        studentMap.put(student1, 23);
        assertThat(studentMap.get(student1)).isEqualTo(23);

        studentMap.put(student1, 33);
        studentMap.put(student1, 113);

        assertThat(studentMap.get(student1)).isEqualTo(113);
    }

    @Test
    public void get_WhenTheValueWasPutted_returnThisValueByKey() {
        studentMap.put(student1, 1);
        studentMap.put(student2, 2);
        studentMap.put(student3, 3);

        assertThat(studentMap.get(student1)).isEqualTo(1);
        assertThat(studentMap.get(student2)).isEqualTo(2);
        assertThat(studentMap.get(student3)).isEqualTo(3);
    }

    @Test
    public void get_WhenValuesAreEqualButKeysAreDifferent_returnPuttedSameValues() {
        studentMap.put(student1, 1);
        studentMap.put(student2, 1);
        studentMap.put(student3, 1);

        assertThat(student1).isNotEqualTo(student2);
        assertThat(student2).isNotEqualTo(student3);
        assertThat(student1).isNotEqualTo(student3);

        assertEquals(studentMap.get(student1), studentMap.get(student2));
        assertEquals(studentMap.get(student1), studentMap.get(student3));
        assertEquals(studentMap.get(student2), studentMap.get(student3));

        assertThat(studentMap.get(student1)).isEqualTo(1);
        assertThat(studentMap.get(student2)).isEqualTo(1);
        assertThat(studentMap.get(student3)).isEqualTo(1);
    }

    @Test
    public void remove_WhenAValueWasRemovedByKey_returnRemovedValue() {
        studentMap.put(student1, ONE);
        studentMap.put(student2, TWO);
        studentMap.put(student3, THREE);

        Integer removedValueOne = studentMap.remove(student1);
        Integer removedValueTwo = studentMap.remove(student2);
        Integer removedValueThree = studentMap.remove(student3);

        assertThat(removedValueOne).isEqualTo(ONE);
        assertThat(removedValueTwo).isEqualTo(TWO);
        assertThat(removedValueThree).isEqualTo(THREE);
    }

    @Test
    public void remove_WhenAValueDoesNotExistButWasRemoved_returnNull() {

        Integer removedValueOne = studentMap.remove(student1);
        Integer removedValueTwo = studentMap.remove(student2);
        Integer removedValueThree = studentMap.remove(student3);

        assertThat(removedValueOne).isEqualTo(null);
        assertThat(removedValueTwo).isEqualTo(null);
        assertThat(removedValueThree).isEqualTo(null);
    }
}
