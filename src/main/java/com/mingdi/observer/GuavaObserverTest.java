package com.mingdi.observer;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Use EventBus to dispatch the events posted to the observers.
 */
public class GuavaObserverTest {

    public static void main(String[] args) {
        Teacher lee = new Teacher();
        lee.setName("lee");
        EventBus eb = new EventBus();
        eb.register(lee);

        Question q = new Question();
        q.setTitle("What day is today?");

        eb.post(q);
    }
}
class Teacher {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Subscribe
    public void raiseQuestion(Question q) {
        System.out.println(String.format("Teacher %s raise a question of : %s", this.getName(), q.getTitle()));
    }
}
class Question {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String title;
    private String content;
}
