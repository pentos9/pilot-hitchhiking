package com.spacex.hitchhiking.annotation.cases;

import com.spacex.hitchhiking.annotation.define.Book;
import com.spacex.hitchhiking.annotation.enums.Priority;
import com.spacex.hitchhiking.annotation.enums.Status;

@Book(author = "Ted Anderson", price = 30, priority = Priority.MEDUIM, status = Status.START)
public class BookTest {
}
