package com.daimabaike.biz.common;

public class ErrorResult {

	private ErrorInfo error;

	public ErrorResult() {

	}

	public ErrorResult(String code, String message) {
		error = new ErrorInfo(code, message);
	}

	public ErrorInfo getError() {
		return error;
	}

	public void setError(ErrorInfo error) {
		this.error = error;
	}

	public static class ErrorInfo {

		private String code;
		private String message;

		public ErrorInfo(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
