package utilities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.Switch;
import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities is factory class that defines a set of methods that perform common, often re-used functions. define most of these common methods under static scope.
 */
public class Utilities {

    public static String contactEmail = "";
    static ProgressBar mProgressBar;
    public static ProgressDialog _progress;
    private static String Amount;
    private static String TotalAmount;
    private static Pattern pattern;
    private static Matcher matcher;
    private static View lineView;
    private static RestRequest restRequest;
    private static JSONObject jsonObject1;
    private static String _nameReservationAmount;

//    /**
//     * Email pattern
//     */
//
//    private static final String EMAIL_PATTERN =
//            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//
//    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
//            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * @param activity:container activity that want this dialog to be shown
     *                           Show Loading dialog which is called all over the application
     */
    public static void showloadingDialog(Activity activity) {
        _progress = new ProgressDialog(activity);
        _progress.setMessage("Loading ...");
        _progress.setCancelable(false);
        _progress.show();
    }

    /**
     * check whether progress is showing to user or not
     */
    public static boolean getIsProgressLoading() {
        if (_progress != null) {
            return _progress.isShowing();
        } else {
            return false;
        }
    }

    /**
     * @param activity:container activity that want this diaog to be shown
     * @param text:text          displayed within loading dialog
     *                           Show Loading dialog which is called all over the application.
     */
    public static void showloadingDialog(Activity activity, String text) {
        _progress = new ProgressDialog(activity);
        _progress.setMessage(text);
        _progress.setCancelable(false);
        _progress.show();
    }

    /**
     * dismiss current shown loading dialog
     */
    public static void dismissLoadingDialog() {
        _progress.dismiss();
    }

    /**
     * @param act:container activity that want this message to be shown
     * @param message:the   message to be shown within toast
     *                      Show short message indicating what message want to be displayed to user
     */
    public static void showToast(Activity act, String message) {
        Toast.makeText(act, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param act:container activity that want this message to be shown
     * @param message:the   message to be shown within toast
     *                      Show long message indicating what message want to be displayed to user
     */
    public static void showLongToast(Activity act, String message) {
        Toast.makeText(act, message, Toast.LENGTH_LONG).show();
    }

    public static String getCurrentDate() {
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date resultdate = new Date(yourmilliseconds);
        return sdf.format(resultdate);
    }
}