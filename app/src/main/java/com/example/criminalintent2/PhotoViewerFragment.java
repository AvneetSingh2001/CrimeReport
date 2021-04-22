package com.example.criminalintent2;

import android.graphics.Bitmap;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PhotoViewerFragment extends DialogFragment {

    private static final String ARG_PHOTO_FILE = "photofile";

    private ImageView mPhotoView;
    private File mPhotoFile;

    public static PhotoViewerFragment newInstance(File photoFile)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO_FILE , photoFile);

        PhotoViewerFragment fragment = new PhotoViewerFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mPhotoFile = (File)getArguments().getSerializable(ARG_PHOTO_FILE);

        View view = inflater.inflate(R.layout.dialog_photo , container , false);

        mPhotoView = (ImageView) view.findViewById(R.id.photo_view_dialog);

        if(mPhotoFile == null || !mPhotoFile.exists())
        {
            mPhotoView.setImageDrawable(null);
        }
        else
        {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath() , getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }

        return view;

    }
}
