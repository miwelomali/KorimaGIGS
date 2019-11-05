package com.example.exa2_restaurantes;

import android.provider.BaseColumns;

public class RestContract {
    public static abstract class RestEntry implements BaseColumns {
        public static final String TABLE_NAME = "Restaurant";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String LOCATION = "location";
        public static final String DESCRIPTION = "description";
        public static final Double RATING = 0.0;
    }
}
