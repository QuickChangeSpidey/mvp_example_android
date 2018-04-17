package com.example.akshay.mvp_example_android;

import org.junit.Before;
import org.junit.Test;

import login.LoginActivityMVP;
import login.LoginActivityPresenter;
import login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;


/**
 * Created by akshay on 4/17/18.
 */

public class PresenterTest {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;
    User user;


    @Before
    public void setup(){
        mockLoginModel = mock(LoginActivityMVP.Model.class);
        user = new User("Akshay","Pandey");

        when(mockLoginModel.getUser()).thenReturn(user);
        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);
        presenter.setView(mockView);

    }

    @Test
    public void noInteractionWithView(){

        presenter.getCurrentUser();
        verifyZeroInteractions(mockView);

    }

    @Test
    public  void loadTheUserFromTheRepositoryWhenValidUserIsPresent(){

        when(mockLoginModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        verify(mockLoginModel, times(1)).getUser();

        verify(mockView, times(1)).setFirstName("Akshay");
        verify(mockView, times(1)).setLastName("Pandey");
        verify(mockView, never()).showUserNotAvailable();


    }

    @Test
    public  void shouldShowErrorMessageWhenUserIsNull(){

        when(mockLoginModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        verify(mockLoginModel, times(1)).getUser();

        verify(mockView, never()).setFirstName("Akshay");
        verify(mockView, never()).setLastName("Pandey");
        verify(mockView, times(1)).showUserNotAvailable();



    }
}
