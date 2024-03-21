import React from 'react';
import { Route, Navigate } from 'react-router-dom';
import { authHeader } from '../helpers/auth-header';

const ProtectedRoute = ({ element, ...rest }) => {
  const isLoggedIn = () => {
    const user = authHeader();
    return !!user?.data?.token; 
  };

  return isLoggedIn() ? (
    <Route {...rest} element={element} />
  ) : (
    <Navigate to="/login" replace />
  );
};

export default ProtectedRoute;
