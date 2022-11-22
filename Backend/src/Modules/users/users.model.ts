import * as mongoose from 'mongoose';
import * as bcrypt from 'bcrypt';
// import appConfig from 'src/Config/app.config';

export interface UserDocument extends mongoose.Document {
  _id: string;
  email: string;
  password: string;
  refreshToken: string;
  comarePassword: (userPassword: string) => Promise<boolean>;
}

export const UserSchema = new mongoose.Schema(
  {
    email: {
      type: String,
      required: true,
      unique: true,
    },
    name: {
      type: String,
      require,
    },
    password: {
      type: String,
      required: true,
    },
    passwordConfirm: {
      type: String,
    },
    refreshToken: {
      type: String,
      select: false,
    },
    Role: {
      type: String,
      enum: ['user', 'admin'],
      default: 'user',
      select: false,
    },
  },
  { timestamps: true, versionKey: false },
);
UserSchema.pre('save', async function (next) {
  // if (!this.isModified('password')) {
  //   return next();
  // }
  // this.password = await bcrypt.hash(this.password, appConfig().SALTROUNDS);
  this.passwordConfirm = undefined;
  next();
});
UserSchema.methods.toJSON = function () {
  const obj = this.toObject();
  delete obj.password;
  return obj;
};

//?Functions
//*To Compare two password
UserSchema.methods.comarePassword = async function (userPassword: string) {
  return await bcrypt.compare(userPassword, this.password);
};
