package com.tourguide.core.state

import com.tourguide.domain.model.User

object SessionState {
    private var user: User? = null;
    private var isLoading: Boolean = true;
    private var isAuthenticated: Boolean = false;

    fun reauthenticateSession() {
        this.user = null;
        this.isLoading = false;
        this.isAuthenticated = false;
    }

    fun initializeSession(user:User) {
        this.user = user;
        this.isLoading = false;
        this.isAuthenticated = true;
    }

    fun getUser():User? {
        return this.user;
    }

    fun isSessionLoading(): Boolean {
        return this.isLoading;
    }

    fun isUserAuthenticated(): Boolean {
        return this.isAuthenticated;
    }
}
