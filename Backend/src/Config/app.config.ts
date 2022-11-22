export default () => ({
  PORT: process.env.PORT,
  MONGODB_URL: process.env.MONGODB_URL,
  SALTROUNDS: Number(process.env.SALTROUNDS) || 10,
  JWT_SECRET: process.env.JWT_SECRET,
  JWT_EXPIRES_IN: process.env.JWT_EXPIRES_IN,
  JWT_REFRESH_SECRET: process.env.JWT_REFRESH_SECRET,
});
