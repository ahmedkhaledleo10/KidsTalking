package com.Lithy.kidstalking.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.Lithy.kidstalking.Model_quiz.Category;
import com.Lithy.kidstalking.Model_quiz.Question;
import com.Lithy.kidstalking.Model_quiz.QuizContract;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private static QuizDbHelper instance;

    private SQLiteDatabase db;

    private QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                QuizContract.CategoriesTable.TABLE_NAME + "( " +
                QuizContract.CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuizContract.QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuizContract.QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                QuizContract.CategoriesTable.TABLE_NAME + "(" + QuizContract.CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";

        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillCategoriesTable() {
        Category c1 = new Category("Arabic");
        insertCategory(c1);
        Category c2 = new Category("English");
        insertCategory(c2);

    }

    public void addCategory(Category category) {
        db = getWritableDatabase();
        insertCategory(category);
    }

    public void addCategories(List<Category> categories) {
        db = getWritableDatabase();

        for (Category category : categories) {
            insertCategory(category);
        }
    }

    private void insertCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(QuizContract.CategoriesTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("اختار الكلمه الصحيحه التي تتناسب مع هذه الكلمه(ن-ع-ا-م-ه)؟",
                "تمساح", "نعامه", "تفاحه", 2,
                Question.DIFFICULTY_HARD, Category.Arabic);
        insertQuestion(q1);

        Question q2 = new Question("اختار الكلمه الصحيحه التي تتناسب مع هذه الكلمه(ر-ق-د)؟",
                "حمار", "حمامه", "قرد", 3,
                Question.DIFFICULTY_MEDIUM, Category.Arabic);
        insertQuestion(q2);

        Question q3 = new Question("اختار الكلمه الصحيحه التي تتناسب مع هذه الكلمه(ف-د-ض-ع)؟",
                "ضفدع", "اسد", "فيل", 1,
                Question.DIFFICULTY_HARD, Category.Arabic);
        insertQuestion(q3);

        Question q4 = new Question("اختار الكلمه الصحيحه التي تتناسب مع هذه الكلمه(ا-ر-ن-ب)؟",
                "معزه", "دجاجه", "ارنب", 3,
                Question.DIFFICULTY_EASY, Category.Arabic);
        insertQuestion(q4);

        Question q5 = new Question("اختار الكلمه الصحيحه التي تتناسب مع هذه الكلمه(س-ا-د)؟",
                "اسد", "زرافه", "ارنب", 1,
                Question.DIFFICULTY_EASY, Category.Arabic);
        insertQuestion(q5);

        Question q6 = new Question("كم عدد حروف هذه الكلمه (زرافه)؟",
                "3", "5", "7", 2,
                Question.DIFFICULTY_MEDIUM,Category.Arabic);
        insertQuestion(q6);

        Question q7 = new Question("كم عدد حروف هذه الكلمه (تمساح)؟",
                "4", "8", "5", 3,
                Question.DIFFICULTY_MEDIUM, Category.Arabic);
        insertQuestion(q7);

        Question q8 = new Question("كم عدد حروف هذه الكلمه (برتقاله)؟",
                "7", "2", "5", 1,
                Question.DIFFICULTY_HARD, Category.Arabic);
        insertQuestion(q8);

        Question q9 = new Question("كم عدد حروف هذه الكلمه (ولد)",
                "7", "3", "8", 2,
                Question.DIFFICULTY_EASY, Category.Arabic);
        insertQuestion(q9);

        Question q10 = new Question("كم عدد حروف هذه الكلمه (عنب)",
                "4", "5", "3", 3,
                Question.DIFFICULTY_EASY, Category.Arabic);
        insertQuestion(q10);

        Question q11 = new Question("ما لون هذه الفاكهه(برتقاله)؟",
                "احمر", "برتقالي", "اخضر", 2,
                Question.DIFFICULTY_MEDIUM, Category.Arabic);
        insertQuestion(q11);

        Question q12 = new Question("ما لون هذه الفاكهه(تفاحه)",
                "احمر", "اصفر", "ازرق", 1,
                Question.DIFFICULTY_MEDIUM, Category.Arabic);
        insertQuestion(q12);

        Question q13 = new Question("ما لون هذه الفاكهه (موز)",
                "اخضر", "اسود", "اصفر", 3,
                Question.DIFFICULTY_EASY, Category.Arabic);
        insertQuestion(q13);

        Question q14 = new Question("ما لون هذه الفاكهه (جوافه)",
                "ازرق", "اصفر", "بنفسجي", 2,
                Question.DIFFICULTY_MEDIUM, Category.Arabic);
        insertQuestion(q14);

        Question q15 = new Question("ما لون هذه الفاكهه (عنب)",
                "اخضر", "احمر", "برتقالي", 1,
                Question.DIFFICULTY_HARD, Category.Arabic);
        insertQuestion(q15);

        Question q16 = new Question("Choose the correct word that matches this word (i-l-o-n)?",
                "rabbit", "Lion", "bird", 2,
                Question.DIFFICULTY_MEDIUM, Category.English);
        insertQuestion(q16);

        Question q17 = new Question("Choose the correct word that matches this word(M-o-n-k-e-y)?",
                "monkey", "donkey", "elephant", 1,
                Question.DIFFICULTY_EASY, Category.English);
        insertQuestion(q17);

        Question   q18 = new Question("Choose the correct word that matches this word(b-r-i-b-a-t)?",
                "Lion", "monkey", "rabbit", 3,
                Question.DIFFICULTY_HARD, Category.English);
        insertQuestion(q18);

        Question  q19 = new Question("Choose the correct word that matches this word(z-e-b-r-a)?",
                "zebra", "banana", "apple", 1,
                Question.DIFFICULTY_EASY, Category.English);
        insertQuestion(q19);

        Question  q20 = new Question("Choose the correct word that matches this word(o-s-c-h-t-r-i)?",
                "moon", "ostrich", "purple", 2,
                Question.DIFFICULTY_HARD, Category.English);
        insertQuestion(q20);

        Question   q21 = new Question("How many letters of this word(ostrich)?",
                "9", "8", "7", 3,
                Question.DIFFICULTY_HARD, Category.English);
        insertQuestion(q21);

        Question    q22 = new Question("How many letters of this word(orange)?",
                "7", "6", "3", 2,
                Question.DIFFICULTY_MEDIUM, Category.English);
        insertQuestion(q22);

        Question   q23 = new Question("How many letters of this word(jam)?",
                "3", "5", "4", 1,
                Question.DIFFICULTY_EASY, Category.English);
        insertQuestion(q23);

        Question   q24 = new Question("How many letters of this word(elephant)?",
                "8", "7", "5", 1,
                Question.DIFFICULTY_HARD, Category.English);
        insertQuestion(q24);

        Question     q25 = new Question("How many letters of this word(Lion)?",
                "6", "4", "2", 2,
                Question.DIFFICULTY_MEDIUM, Category.English);
        insertQuestion(q25);

        Question    q26 = new Question("What color is this fruit(Apple)?",
                "green", "blue", "red", 3,
                Question.DIFFICULTY_EASY, Category.English);
        insertQuestion(q26);

        Question   q27 = new Question("What color is this fruit(lemon)?",
                "yellow", "red", "purple", 1,
                Question.DIFFICULTY_MEDIUM, Category.English);
        insertQuestion(q27);

        Question q28 = new Question("What color is this fruit(orange)?",
                "orange", "black", "white", 1,
                Question.DIFFICULTY_EASY, Category.English);
        insertQuestion(q28);

        Question   q29 = new Question("What color is this fruit(banana)?",
                "green", "purple", "yellow", 3,
                Question.DIFFICULTY_MEDIUM, Category.English);
        insertQuestion(q29);

        Question   q30 = new Question("What color is this fruit(Guava)?",
                "three", "fruit", "yellow", 3,
                Question.DIFFICULTY_HARD, Category.English);
        insertQuestion(q30);


    }

    public void addQuestion(Question question) {
        db = getWritableDatabase();
        insertQuestion(question);
    }

    public void addQuestions(List<Question> questions) {
        db = getWritableDatabase();

        for (Question question : questions) {
            insertQuestion(question);
        }
    }

    private void insertQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuizContract.QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuizContract.QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.CategoriesTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(QuizContract.CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(QuizContract.CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while (c.moveToNext());
        }

        c.close();
        return categoryList;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(int categoryID, String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuizContract.QuestionsTable.COLUMN_CATEGORY_ID + " = ? " +
                " AND " + QuizContract.QuestionsTable.COLUMN_DIFFICULTY + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};

        Cursor c = db.query(
                QuizContract.QuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
