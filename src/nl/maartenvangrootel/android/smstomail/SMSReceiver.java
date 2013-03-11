package nl.maartenvangrootel.android.smstomail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
	private static final String TAG = "SMSReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		// Get the extra's from the intent.
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			// Retrieve message-parts received.
			Object[] pdus = (Object[]) bundle.get("pdus");
			SmsMessage[] messages = new SmsMessage[pdus.length];
			for (int i = 0; i < messages.length; i++) {
				SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
				Log.i(TAG, message.getDisplayMessageBody());
			}
		}
	}
}
