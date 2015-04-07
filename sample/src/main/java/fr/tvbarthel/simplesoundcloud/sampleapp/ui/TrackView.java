package fr.tvbarthel.simplesoundcloud.sampleapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.tvbarthel.simplesoundcloud.library.helpers.SoundCloudArtworkHelper;
import fr.tvbarthel.simplesoundcloud.library.client.SoundCloudTrack;
import fr.tvbarthel.simplesoundcloud.sampleapp.R;

/**
 * Simple View used to render a track.
 */
public class TrackView extends FrameLayout {

    private ImageView mArtwork;
    private TextView mTitle;

    private SoundCloudTrack mModel;

    /**
     * Simple View used to render a track.
     *
     * @param context calling context.
     */
    public TrackView(Context context) {
        super(context);
        if (!isInEditMode()) {
            init(context);
        }
    }

    /**
     * Simple View used to render a track.
     *
     * @param context calling context.
     * @param attrs   attr from xml.
     */
    public TrackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init(context);
        }
    }

    /**
     * Simple View used to render a track.
     *
     * @param context      calling context.
     * @param attrs        attr from xml.
     * @param defStyleAttr style from xml.
     */
    public TrackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            init(context);
        }
    }

    /**
     * Set the track which must be displayed.
     *
     * @param track view model.
     */
    public void setModel(SoundCloudTrack track) {
        mModel = track;
        if (mModel != null) {
            Picasso.with(getContext())
                    .load(SoundCloudArtworkHelper.getArtworkUrl(mModel, SoundCloudArtworkHelper.LARGE))
                    .into(mArtwork);
            mTitle.setText(mModel.getArtist() + " - " + mModel.getTitle());
        }
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.track_view, this);

        mArtwork = ((ImageView) findViewById(R.id.track_view_artwork));
        mTitle = ((TextView) findViewById(R.id.track_view_title));

        setBackgroundColor(getResources().getColor(R.color.grey_color));
    }
}
