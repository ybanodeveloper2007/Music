package com.ritmoli.preference;

import io.paperdb.Book;
import io.paperdb.Paper;

/**
 * Created by user on 11/13/2017.
 */

public class MyPreference {
    /**
     * before use this class the user must have to implement the paper library for shared preference.
     */
    public static final Book myPref = Paper.book(PaperConstant.BOOK_NAME);

}
