package org.crg.cleancraft.chap2;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

@DisplayName("FifoQueue")
class FifoQueueTest {

    private FifoQueue queue;

    @BeforeEach
    void init() {
        queue = new FifoQueue();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertThat(queue.isEmpty()).isTrue();
        }

        @Test
        @DisplayName("throws exception after dequeuing")
        void throwsExceptionAfterDequeuing() {
            assertThatThrownBy(() -> queue.dequeue()).isInstanceOf(IllegalStateException.class);
        }

        @Nested
        @DisplayName("after enqueuing single element")
        class AfterEnqueuingSingleElement {

            @Test
            @DisplayName("is no longer empty")
            void enqueuesInteger() {
                queue.enqueue(0);

                assertThat(queue.isEmpty()).isFalse();
                assertThat(queue.size()).isOne();
            }

            @Test
            @DisplayName("is empty after dequeueing element")
            void isEmptyhAfterDequeuingElement() {
                queue.enqueue(0);
                queue.dequeue();

                assertThat(queue.isEmpty()).isTrue();
                assertThat(queue.size()).isZero();
            }

            @Test
            @DisplayName("dequeues enqueued element")
            void dequeuesEnqueuedElement() {
                queue.enqueue(0);
                var dequeuedElement = queue.dequeue();

                assertThat(dequeuedElement).isZero();
            }
        }

        @Nested
        @DisplayName("after enqueuing three elements")
        class AfterEnqueuingThreeElements {

            @BeforeEach
            void init() {
                queue.enqueue(0);
                queue.enqueue(1);
                queue.enqueue(2);
            }

            @Test
            @DisplayName("size is three")
            void sizeIsThree() {
                assertThat(queue.size()).isEqualTo(3);
            }

            @Test
            @DisplayName("dequeues first enqueued element")
            void dequeuesFirstEnqueuedElement() {
                var dequeuedElement = queue.dequeue();

                assertThat(dequeuedElement).isZero();
                assertThat(queue.size()).isEqualTo(2);
            }

            @Test
            @DisplayName("dequeues second enqueued element")
            void dequeuesSecondEnqueuedElement() {
                queue.dequeue();

                var dequeuedElement = queue.dequeue();

                assertThat(dequeuedElement).isOne();
                assertThat(queue.size()).isOne();
            }

            @Test
            @DisplayName("enqueues another element")
            void enqueuesAnotherElement() {
                queue.dequeue();
                queue.enqueue(3);

                assertThat(queue.size()).isEqualTo(3);
            }

            @Test
            @DisplayName("throws exception when trying to enqueue beyond capacity")
            void throwsExceptionWhenTryingToEnqueueBeyondCapacity() {
                assertThatThrownBy(() -> queue.enqueue(3)).isInstanceOf(IllegalStateException.class);
                assertThat(queue.size()).isEqualTo(3);
            }
        }

    }

}
