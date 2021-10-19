import java.util.Objects;

class stu implements Comparable<stu>{
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stu stu = (stu) o;
        return age == stu.age && Objects.equals(name, stu.name);
    }

    public stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(stu o) {
        return age-o.age;
    }

}
