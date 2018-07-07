package com.hzg.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhengguohuang
 */
public class DogCatQueue {

    public class Pet {
        private String type;
        public Pet(String type){
            this.type = type;
        }
        public String getType() {
            return this.type;
        }
    }

    public class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }

    public class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }

    public static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getType();
        }
    }

    public static class DoCaQueue {
        private static final String DOG = "dog";
        private static final String CAT = "cat";
        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;
        private long count;

        public DoCaQueue() {
            dogQ = new LinkedList<>();
            catQ = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet) {
            if (DOG.equals(pet.getType())) {
                this.dogQ.add(new PetEnter(pet, this.count++));
            } else if (CAT.equals(pet.getType())) {
                this.catQ.add(new PetEnter(pet, this.count++));
            } else {
                throw new RuntimeException("err, not cat or dog");
            }
        }

        /**
         * 猫狗队列出队一个最先进入队列的
         * @return 队首
         */
        public Pet pollAll() {
            // 1.猫队列和狗队列都非空
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                return this.dogQ.peek().getCount() < this.catQ.peek().getCount() ? this.dogQ.poll().getPet() : this.catQ.poll().getPet();
            }
            // 2.狗队列非空
            else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            }
            // 3.猫队列非空
            else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            }
            // 4.猫狗队列都为空
            else {
                throw new RuntimeException("queue is empty");
            }
        }

        public Dog pollDog() {
            if (!this.isDogQueueEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        public Cat pollCat() {
            if (!this.isCatQueueEmpty()) {
                return (Cat) this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("Cat queue is empty!");
            }
        }

        public boolean isEmpty() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return this.dogQ.isEmpty();
        }

    }


}
