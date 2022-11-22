import { createParamDecorator, ExecutionContext } from '@nestjs/common';
import { UserDecoratorType } from '../Interfaces/user.decorators.interface';

export const User = createParamDecorator<any, any, UserDecoratorType>(
  (data: unknown, ctx: ExecutionContext): UserDecoratorType => {
    const request = ctx.switchToHttp().getRequest();
    return request.user;
  },
);
