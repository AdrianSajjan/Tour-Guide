import { Catch, ArgumentsHost, HttpStatus } from '@nestjs/common';
import { BaseExceptionFilter } from '@nestjs/core';
import { Response } from 'express';
import * as mongoose from 'mongoose';

@Catch(mongoose.mongo.MongoServerError)
export class AllExceptionsFilter extends BaseExceptionFilter {
  catch(exception: unknown, host: ArgumentsHost) {
    const ctx = host.switchToHttp();
    const response = ctx.getResponse<Response>();
    // const request = ctx.getRequest<Request>();
    let status = HttpStatus.BAD_REQUEST;
    let message = 'Integernal Server Error';

    //*Mongoose Duplicate Key Error Handler
    if (exception instanceof mongoose.mongo.MongoServerError) {
      message = 'username Alredy Exist';
      status = HttpStatus.BAD_REQUEST;
    }

    response.status(status).json({
      statusCode: status,
      message,
      timestamp: new Date().toISOString(),
    });
  }
}
