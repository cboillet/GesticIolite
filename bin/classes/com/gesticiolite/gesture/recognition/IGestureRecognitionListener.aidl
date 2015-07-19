package com.gesticiolite.gesture.recognition;
import com.gesticiolite.gesture.recognition.Distribution;

interface IGestureRecognitionListener {
	void onGestureRecognized(in Distribution distribution);

	 void onGestureLearned(String gestureName);

	 void onTrainingSetDeleted(String trainingSet);
} 


