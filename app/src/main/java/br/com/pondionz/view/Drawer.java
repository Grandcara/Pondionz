/*
 *  Copyright (C) 2016 Iago de Castro Alvarenga <iagodecastro@yahoo.com.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *
 */

package br.com.pondionz.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;



import br.com.pondionz.R;
import br.com.pondionz.control.StableArrayAdapterDrawerList;

/**
 * Created by Iago on 22/02/2016.
 */
public class Drawer {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Activity activity;
    public Drawer(Activity activity){
        this.activity = activity;
        setDrawer();
    }

    private void setDrawer() {
        //mOptionsTitles = new String[]{"Opções", "Linhas", "Favoritos", "Sobre","Parceiros"};
        String[] mOptionsTitles = new String[]{"", "Linhas", "Favoritos", "Sobre", "Configurações", "Parceiros"};
        //String[] mOptionsTitles = new String[]{"", "Linhas", "Favoritos", "Sobre", "Configurações"};

        mDrawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) activity.findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        StableArrayAdapterDrawerList adapter = new StableArrayAdapterDrawerList(activity, mOptionsTitles);
        mDrawerList.setAdapter(adapter);
        Toolbar toolbar = new Toolbar(activity);
        Toolbar.LayoutParams tblw = new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER | Gravity.RIGHT);

        activity.addContentView(toolbar,tblw);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        mDrawerToggle = new ActionBarDrawerToggle(
                activity,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }



    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {
        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawers();

        switch (position) {
            case 1:
                new LinhasView().limpar();
                Intent intent = new Intent(activity, LinhasView.class);
                activity.startActivity(intent);
                break;
            case 2:
                Intent intent2 = new Intent(activity, Favorite.class);
                activity.startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(activity, HelpList.class);
                activity.startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(activity, Settings.class);
                activity.startActivity(intent4);
                break;
        }
    }

    public void SyncState() {
        mDrawerToggle.syncState();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            selectItem(i);
        }
    }

}
